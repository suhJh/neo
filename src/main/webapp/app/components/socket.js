import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import { now } from '../util';
import request from 'superagent';

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

    /* 프론트랑 백이랑 타임 포맷 맞춰야지 나온다. */
    const initialData = JSON.stringify({ timestamp: now() });
    stompClient.send('/crud/welcome', {}, initialData);
  });
}

export function disconnect() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  setConnected(false);
  console.log('Disconnected');
}

export function send(message) {
  //  stompClient.send('/crud/insertMessage', {}, JSON.stringify({ name }));
  request
    .post('/api/message/write')
    .type('json')
    .send({
      sender: {
        seq: 1,
      },
      timestamp: now(),
      message,
    })
    .end((err, data) => {
      console.log(data.body);
    });
}
