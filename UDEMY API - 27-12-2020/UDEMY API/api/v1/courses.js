/**
 * Contains the definition of the API endpoints for vacation packages
 * 
 */
// As a best practice keep the resource name same as the file name
var RESOURCE_NAME = 'courses';
var VERSION = 'v1';
var URI = '/' + VERSION + '/' + RESOURCE_NAME; 

// Setup the vacations db
var db = require('../../db/courses')
var apiErrors = require('../../util/errors')
var apiMessages = require('../../util/messages')


module.exports = function(router){
    'use strict';

    // RETRIEVE all active vacation packages
    // Active = validTill >= Today's date

    //    /v1/Vacations
    router.route(URI).get(function(req, res,next){
        console.log("GET Udemy Courses")

        var fields ={}
        if(req.query && req.query.fields !== undefined){
           fields =  createFields(req.query.fields)
        }
        var pagination = {limit:0, offset:0}
        
        if(req.query && req.query.limit !== undefined){
            pagination.limit = req.query.limit
        }
        if(req.query && req.query.offset !== undefined){
            pagination.offset = req.query.offset
        }

        var options = {fields:fields, pagination:pagination}
        console.log(options)
        db.select( options,function(err,docs){  
            if(err){
                console.log(err)
                res.status(500)
                res.send("Error connecting to db")
            } else {
                if(docs.length == 0){
                    res.status(404)
                }
                console.log("Retrieved Course Details = %d",docs.length)
                res.send(docs)
            }
        });
    });

    // CREATE new vacation packages
    router.route(URI).post(function(req, res,next){
        console.log("POST Udemy  Courses")

        //1. Get the data
        var doc = req.body;

        //2. Call the insert method
        db.save(doc, function(err,saved){
            if(err){
                // The returned error need to be defined better - in this example it is being left as is
                var userError = processMongooseErrors(apiMessages.errors.API_MESSAGE_CREATE_FAILED, "POST", URI, err,{});
                res.setHeader('content-type', 'application/json')
                res.status(400).send(userError)
            } else {
                res.send(saved)
            }
        });
    });
        
    router.route(URI).delete(function(req, res,next){
        console.log("Successfully Removed data");
        var criteria = {name:"Varadha"}
        db.delete(criteria,function(err,deleted){
            if(err){
                console.log(err)
                res.status(500)
                res.send("Error connecting to db")
            } else {
                console.log("Deleted courses = %d",deleted.length)
                res.send(deleted)
            }f
        });
    });

    router.route(URI).put(function(req,res,next){
        console.log("update data")
        var criteria = {_id:'5fe88abf70ae561f5ce5c1b8'}
        var doc = req.body;
        db.update(criteria,doc,function(err,updated){
            if(err){
                console.log(err)
                res.status(500)
                res.send("Error connecting to db")
            } else {
                console.log("updated courses = %d",updated.length)
                res.send(updated)
            }
        })
    });

    /**
 * Converts the Mongoose validation errors to API specific errors
 */
var processMongooseErrors = function (message, method, endpoint, err,payload) {
    var errorList = []
    // Check for validation error
    if (err.name === 'ValidationError'){
        errorList = processValidationErrors(err)
    } else if(err.code == 11000){
        // it could be database error - 11000 is for duplicate key
        errorList.push(apiErrors.errors.PACKAGE_ALREADY_EXISTS)
    } else {
        var errUnknown = apiErrors.errors.UNKNOWN_ERROR
        errUnknown.payload = err
        errorList = [apiErrors.errors.UNKNOWN_ERROR]
    }
    return apiErrors.create(message, method, endpoint, errorList, payload)
}

/**
 * Converts Mongoose errors to API specific errors
 */
var processValidationErrors = function (err) {
    var errorList = []

  
    if (err.errors.durationInHours) {
        if (err.errors.durationInHours.kind === apiErrors.kinds.MIN_ERROR 
        || err.errors.durationInHours.kind === apiErrors.kinds.NUMBER_ERROR ) {
            errorList.push(apiErrors.errors.FORMAT_DURATION)
        }
    }

    if (err.errors.price) {
        if (err.errors.price.kind === apiErrors.kinds.MIN_ERROR 
        || err.errors.price.kind === apiErrors.kinds.NUMBER_ERROR ) {
            errorList.push(apiErrors.errors.FORMAT_PRICE)
        }
    }

    if (err.errors.code) {
        if (err.errors.code.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_COURSE_CODE)
        }
    }

    if (err.errors.name) {
        if (err.errors.name.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_COURSE_NAME)
        }
    }


    if (err.errors.description) {
        if (err.errors.description.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_COURSE_DESCRIPTION)
        }
    }

    if (err.errors.category) {
        if (err.errors.category.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_COURSE_CATEGORY)
        }
    }
   
    if (err.errors.durationInHours) {
        if (err.errors.durationInHours.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_COURSE_DURATION_IN_HOURS)
        }
    }

    if (err.errors.authors) {
        if (err.errors.authors.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_COURSE_AUTHOR)
        }
    }
    
    if (err.errors.price) {
        if (err.errors.price.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_COURSE_PRICE)
        }
    }
    
    return errorList;

}
    }