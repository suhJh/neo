import React, { Component } from 'react';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import reducers from '../redux/reducers';
import ChatContainer from './ChatContainer';
import ChatInput from './ChatInput';

const store = createStore(reducers);

const next = store.dispatch;

store.dispatch = function dispatchAndLog(action) {
  console.log('dispatching', action);
  const result = next(action);
  console.log('next state', store.getState());
  return result;
};

export default class App extends Component {
  componentDidMount() {
    connect();
  }
  render() {
    return (
      <div>
        <Provider store={store}>
          <ChatContainer />
        </Provider>
        <ChatInput send={send} />
      </div>
    );
  }
}
