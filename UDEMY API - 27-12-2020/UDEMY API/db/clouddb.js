const DB_USER='root';
const DB_PASSWORD ='rootpassword';
const DB_NAME ='UdemyLearning';
const CLUSTER_HOST ='apidemo.c5v7b.mongodb.net';

//mongodb+srv://root:<password>@apidemo.c5v7b.mongodb.net/<dbname>?retryWrites=true&w=majority

exports.DB_URI = `mongodb+srv://${DB_USER}:${DB_PASSWORD}@${CLUSTER_HOST}/${DB_NAME}?retryWrites=true&w=majority`;

