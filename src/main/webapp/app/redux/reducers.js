import { combineReducers } from 'redux';
import request from 'superagent';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import { newChat, prevList } from './actions';
import { now } from '../util';

let stompClient = null;

export function connect() {
  const socket = new SockJS('/payroll');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, (frame) => {
    console.log(`Connected: ${frame}`);
    stompClient.subscribe('/subscribe/messages', (messages) => {
      showGreeting(JSON.parse(messages.body).content);
    });

    /* 프론트랑 백이랑 타임 포맷 맞춰야지 나온다. */
    const initialData = JSON.stringify({ timestamp: now() });
    stompClient.send('/crud/welcome', {}, initialData);
  });
}


const chats = (state = [], action) => {
  switch (action.type) {
    case newChat:
      return [...state, action.chat];
    case prevList:
      return [...action.chats, ...state];
    default:
      return state;
  }
};

// state
const reducers = combineReducers({
  chats,
});

export default reducers;
