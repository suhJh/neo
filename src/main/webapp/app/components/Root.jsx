import React, { Component } from 'react';
import { Provider } from 'react-redux';
import configureStore from '../redux/configureStore';
import App from './App';

const store = configureStore();

export default class Root extends Component {
  render() {
    return (
      <div>
        <Provider store={store}>
          <App />
        </Provider>
      </div>
    );
  }
}
