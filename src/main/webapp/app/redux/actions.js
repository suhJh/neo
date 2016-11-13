import request from 'superagent';
import { now } from '../util';


export const chatActions = {
  getNewSingleChat: 'getNewSingleChat',
  getPreviousChatsByTimestamp: 'getPreviousChatsByTimestamp',
};

export function getNewSingleChat(chat) {
  return {
    type: chatActions.getNewSingleChat,
    chat,
    receivedAt: now(),
  };
}

function getPreviousChatsByTimestamp(chats) {
  return {
    type: chatActions.getPreviousChatsByTimestamp,
    chats,
    receivedAt: now(),
  };
}

/* 비동기로 뱉기 위해 래핑함수를 export.. newPattern임 */
export function asyncGetList(dispatch, chat) {
  request
    .post('/api/message/getPreviousChatsByTimestamp')
    .type('json')
    .send({
      timestamp: chat ? chat.timestamp : now(),
    })
    .end((err, data) => {
      console.log('매우 중요함!!', data.body);
      dispatch(getPreviousChatsByTimestamp(data.body));
    });
}
