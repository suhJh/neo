import React, { Component } from 'react';
import ChatContainer from './ChatContainer';
import ChatInput from './ChatInput';
import {
  setConnected,
  connect,
  disconnect,
  send,
} from './socket';

export default class App extends Component {
  componentDidMount() {
    connect();
  }
  render() {
    return (
      <div>
        <ChatContainer />
        <ChatInput send={send} />
      </div>
    );
  }
}
