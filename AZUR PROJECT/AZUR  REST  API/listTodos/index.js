// var mongoClient = require("mongodb").MongoClient;
// mongoClient.connect("mongodb://cosmos-db-ust-todos:bMGjHncYnzpu5fmKxJt4jeh2ti3M8BdNSoLbid8XGV3NZHJvbJZBxIus7LaWznd91hh76tWjl0Gspu4pCbTaVQ==@cosmos-db-ust-todos.mongo.cosmos.azure.com:10255/?ssl=true&appName=@cosmos-db-ust-todos@", function (err, db) {
//   db.close();
// });

const MongoClient = require("mongodb").MongoClient;
module.exports = async function (context, req) {

    const URL = process.env.MONGODB_URL;
    const DATABASE_NAME = process.env.MONGODB_DATABASE_NAME;
    const COLLECTION_NAME = process.env.MONGODB_COLLECTION_NAME;

    const connection = await MongoClient.connect(URL);
    const todosCollection = connection.db(DATABASE_NAME).collection(COLLECTION_NAME);

    const result = await todosCollection.find({}).toArray();

    await connection.close();

    return {
        body: JSON.stringify(result).replace(/_id/g,"id")
    };
}