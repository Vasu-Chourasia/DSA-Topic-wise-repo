import { createServer } from "node:http";

const server = createServer((req, res) => {
  if (req.method === "GET" && req.url === "/users") {
    res.writeHead(200, {
      "Content-Type": "application/json"
    });

    res.end(JSON.stringify([
      { id: 1, name: "Asha" }
    ]));
  } else {
    res.writeHead(404);
    res.end("Not found");
  }
});

server.listen(3000);