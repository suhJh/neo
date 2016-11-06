import React, { Component } from 'react';
import ChatContainer from './ChatContainer';
import ChatInput from './ChatInput';
import {
  setConnected,
  connect,
  disconnect,
  sendName,
} from './socket';

export default class App extends Component {
  componentDidMount() {
    connect();
  }
  render() {
    return (
      <div>
        <ChatContainer />
        <ChatInput send={sendName} />
      </div>
    );
  }
}
