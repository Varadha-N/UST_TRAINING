/**
 * "REST API Course"
 * 
 * Model for the ACME vacation package.
 */

var settings = require('../db/settings')


var CourseSchema = settings.mongoose.Schema(
    {
        code:{type:String, required:[true,'Course Code is Required']},
        name : {type:String, required:[true,'Course Name is Required']},
        description : {type:String, required:true},
        category : {type:String, required:[true,'Course category is required']},
        keywords : {type:[String],required:false},
        contents : [{
            title:{type:String, required:true},
            video : {type:String, required:false}
        }],
        durationInHours:{type: Number, required:true, min:0},
        price:{type: Number, required:true, min:0},
        offer : {
            discount: Number,
            validTill:{type:Date, required:false}
        },
        authors : {type:[String],required:true},
        rating : {type: Number, required:true, min:0 , max:5},
        reviews : [{
            name : {type:String, required:true},
            comment : {type:String , required:true}
        }]
    }
);

// Export the model
exports.Courses = settings.mongoose.model('courses', CourseSchema)