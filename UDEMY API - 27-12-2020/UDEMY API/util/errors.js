/**
 * Maintains all error codes
 * You may externalize this file and read it as JSON data at the time of initialization
 */
exports.errors = {
    // This is a catch all error
    // Ideally this should never be thrown
    UNKNOWN_ERROR : {
        code:500,
        text:"Unknown error !!!",
        hints:["Please contact development team wit information on 'how to reproduce this error'. Thank you for your help and support."],
        info:"http://developer.acme.com/unknownerror"
    },

    PACKAGE_ALREADY_EXISTS :{
        code:420,
        text:"Course package with the provided 'course code' already exist",
        hints:["Please use PUT for update instead of POST"],
        info:"http://developer.acme.com/errors#420"
    },

    // All required/missing field errors start with number 7
    MISSING_COURSE_CODE : {
        code:700,
        text:"Required field course 'code' is missing",
        hints:["Please check that user has provided the non null value for 'code'"],
        info:"http://developer.acme.com/error#RequiredFields"
    },

    MISSING_COURSE_NAME :  {
        code:701,
        text:"Required field course 'name' is missing",
        hints:["Please check that user has provided the non null value for 'name'"],
        info:"http://developer.acme.com/error#RequiredFields"
    }  ,

    MISSING_COURSE_DESCRIPTION : 
    {
        code:703,
        text:"Required field course 'description' is missing",
        hints:["Please check that user has provided the non null value for description"],
        info:"http://developer.acme.com/error#RequiredFields"
    },

    MISSING_COURSE_CATEGORY : 
    {
        code:704,
        text:"Required field course 'category' is missing",
        hints:["Please check that user has provided the non null value for course category"],
        info:"http://developer.acme.com/error#RequiredFields"
    },
    
    MISSING_COURSE_DURATION_IN_HOURS : 
    {
        code:705,
        text:"Required field course 'duration in hours' is missing",
        hints:["Please check that user has provided the non null value for course duration-in-hours (greater than 1)"],
        info:"http://developer.acme.com/error#RequiredFields"
    },
    
    MISSING_COURSE_PRICE : 
    {
        code:706,
        text:"Required field course 'price' is missing",
        hints:["Please check that user has provided the non null value for course price (greater than 0)"],
        info:"http://developer.acme.com/error#RequiredFields"
    },
 
    MISSING_COURSE_AUTHOR : 
    {
        code:707,
        text:"Required field course 'author' is missing",
        hints:["Please check that user has provided the non null value for course author"],
        info:"http://developer.acme.com/error#RequiredFields"
    },


    FORMAT_DURATION : {
        code:707,
        text:"Duration Must be a number ,greater than or equal to 1",
        hints:["Please check that user has provided a numeric value for 'duration -in-hours'"],
        info:"http://developer.acme.com/error#RequiredFields"
    },

    FORMAT_PRICE : {
        code:708,
        text:"Price Must be a number ,greater than or equal to 1",
        hints:["Please check that user has provided a numeric value for 'price'"],
        info:"http://developer.acme.com/error#RequiredFields"
    }

}

/**
 * Utility methods
 * Creates the error response body to be sent back to the caller
 */
exports.create = function(message,httpMethod,endpointInformation,errorList,receivedPayload){
    return    {
        // Meant for the developer 
        text:message,
        timestamp:new Date(),
        // POST, GET ....
        method:httpMethod,
        // Endpoint information
        endpoint:endpointInformation,
        // An array of all errors
        errors : errorList,
        // OPTIONAL - Use only during development
        payload: receivedPayload
    }
}

// Mongoose validation error types
exports.kinds = {
    REQUIRED:"required",
    NOT_VALID:"notvalid",
    NUMBER_ERROR:"Number",
    MIN_ERROR:"min",
    MAX_ERROR:"max",
}

