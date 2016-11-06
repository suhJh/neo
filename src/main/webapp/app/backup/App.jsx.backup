import React, { Component, PropTypes } from 'react';
import {
  setConnected,
  connect,
  disconnect,
  sendName,
} from './socket';

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      text: '',
      received: '방가',
    };
    this.send = this.send.bind(this);
  }
  send() {
    if (this.text.value) {
      sendName(this.text.value);
    }
  }
  render() {
    const { title } = this.props;
    const { received } = this.state;
    return (
      <div className="container">
        <h2>{title}</h2>
        <div className="row">
          <div>
            {received}
          </div>
          <div>
            <button type="button" onClick={connect}>connect</button>
            <button type="button" onClick={disconnect}>disconnect</button>
            <button type="button" onClick={this.send}>sendName</button>
          </div>
          <div className="form-group">
            <input
              type="text"
              ref={(ref) => { this.text = ref; }}
            />
            <button type="button" onClick={this.send}>전송</button>
          </div>
        </div>
      </div>
    );
  }
}

App.propTypes = {
  title: PropTypes.string.isRequired,
};
