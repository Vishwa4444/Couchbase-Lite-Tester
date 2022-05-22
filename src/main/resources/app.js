var http = require('http');
 
// Create a server object:
http.createServer(function (req, res) {
 
    // Write a response to the client
    res.write('hello vishwa');
 
    // End the response
    res.end();
 
// The server object listens on port 8080
}).listen(8080);
