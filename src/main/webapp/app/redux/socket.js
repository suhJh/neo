import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import { getNewSingleChat } from './actions';

let stompClient = null;

export default function socketIntialize(dispatch) {
  const socket = new SockJS('/payroll');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, (frame) => {
    console.log(`Connected: ${frame}`);
    stompClient.subscribe('/subscribe/messages', (messages) => {
      dispatch(getNewSingleChat(JSON.parse(messages.body)));
    });
  });
}
/* 프론트랑 백이랑 타임 포맷 맞춰야지 나온다. */
//  const initialData = JSON.stringify({ timestamp: now() });
//  stompClient.send('/crud/welcome', {}, initialData);
//  dispatch(getNewSingleChat(JSON.parse(messages.body).content));
