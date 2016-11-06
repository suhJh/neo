import Stomp from 'stompjs';
import SockJS from 'sockjs-client';


let stompClient = null;

export function setConnected(connected) {
  console.log(connected);
}

function showGreeting(message) {
  console.log(message);
}

export function connect() {
  const socket = new SockJS('/payroll');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, (frame) => {
    setConnected(true);
    console.log(`Connected: ${frame}`);
    stompClient.subscribe('/subscribe/messages', (messages) => {
      showGreeting(JSON.parse(messages.body).content);
    });

    stompClient.send('/crud/welcome', {}, JSON.stringify({ message: 'c8c8', sender: { seq: 1 }, timestamp: Date.now() }));
  });
}

export function disconnect() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  setConnected(false);
  console.log('Disconnected');
}

export function sendName(name) {
  stompClient.send('/crud/insertMessage', {}, JSON.stringify({ name }));
}
