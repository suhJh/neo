import { combineReducers } from 'redux';
import { CRUD } from './actions';
import { createUUID } from './../util';

/* 변수명이 곧 state 키임 */
const posts = (state = [], action) => {
  switch (action.type) {
    case CRUD.INSERT:
      return [
        ...state,
        Object.assign({}, action.post, { id: createUUID(), at: Date.now() }),
      ];
    case CRUD.DELETE:
      return [
        ...state.slice(0, state.find(it => it.id === action.post.id)),
        ...state.slice(state.find(it => it.id === action.post.id) + 1),
      ];
    case CRUD.UPDATE:
      return [
        ...state.slice(0, state.find(it => it.id === action.post.id)),
        Object.assign({}, action.post.id),
        ...state.slice(state.find(it => it.id === action.post.id) + 1),
      ];
    case CRUD.SELECT:
      return state;
    default:
      return state;
  }
};

// state
const reducers = combineReducers({
  posts,
});

export default reducers;
