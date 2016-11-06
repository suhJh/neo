import React, { Component } from 'react';
import { Row } from 'react-bootstrap';
import { Provider } from 'react-redux';
import configureStore from '../configureStore';
import AsyncApp from './AsyncApp';

const store = configureStore();

export default class Root extends Component {
  render() {
    return (
      <Row style={{ marginTop: '30px' }}>
        <Provider store={store}>
          <AsyncApp />
        </Provider>
      </Row>
    );
  }
}
