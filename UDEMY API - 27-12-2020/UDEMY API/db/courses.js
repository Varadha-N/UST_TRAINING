/**
 * All database operations related to the vacations collection will reside in this file
 */
var model = require('../course_models/coursesModel')
var settings = require('./settings')

// CREATE the vacation package
exports.save = function (data, callback) {
    new model.Courses(data).save(function (err, inserted) {
        callback(err, inserted)

    })
}

// CREATE multiple vacation packages
exports.saveMany = function (rows, callback) {
    model.Courses.insertMany(rows, function (err, docs) {
        callback(err, docs)
    })

}

// UPDATE the vacation packages
exports.update = function (criteria, doc, callback) {
    model.Courses.updateMany(criteria, doc, function (err, data) {
        callback(err, data)

    })
}

// RETRIEVE vacation packages based on criteria
// exports.select = function (criteria, callback) {
//     model.Courses.find(criteria, function (err, data) {
//         callback(err, data)
//     })
// }

exports.select = function (options, callback) {
    var lim = 0
    var off = 0
    if(options.pagination !== undefined){
        if(options.pagination.limit !== undefined)  lim = parseInt(options.pagination.limit)
        if(options.pagination.offset !== undefined)  off = parseInt(options.pagination.offset)
    }

    model.Courses.find(function (err, data) {
        callback(err, data)
    }).select(options.fields).limit(lim).skip(off)
}

exports.delete = function(criteria,callback)
{
    model.Courses.deleteOne(criteria,function(err,data){
        callback(err,data)
    })
} 