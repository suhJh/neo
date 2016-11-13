import { combineReducers } from 'redux';
import { chatActions } from './actions';

const chats = (state = [], action) => {
  switch (action.type) {
    case chatActions.getNewSingleChat:
      return [...state, action.chat];
    case chatActions.getPreviousChatsByTimestamp:
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
