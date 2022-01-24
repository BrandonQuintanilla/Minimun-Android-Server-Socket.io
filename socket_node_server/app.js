import { createServer } from "http";
import { Server } from "socket.io";

const httpServer = createServer();
const io = new Server(httpServer, {
  // options
  
});

//Ejecutar con "node app" con el cursor en la base del proyecto
console.log("SERVER INIT: " )

io.on("connection", (socket) => {
  // ...

  console.log("conectado: " + socket)

});

httpServer.listen(5000);