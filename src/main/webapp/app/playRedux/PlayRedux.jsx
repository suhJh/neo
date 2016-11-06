import React, { Component } from 'react';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import reducers from './reducers';
import App from './App';

const store = createStore(reducers);

const next = store.dispatch;

store.dispatch = function dispatchAndLog(action) {
  console.log('dispatching', action);
  const result = next(action);
  console.log('next state', store.getState());
  return result;
};

export default class PlayRedux extends Component {
  render() {
    return (
      <div className="container">
        <div className="row">
          <div className="page-header">
            <h1>playRedux!</h1>
          </div>
          <Provider store={store}>
            <App />
          </Provider>
        </div>
      </div>
    );
  }
}
