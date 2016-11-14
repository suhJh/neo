import React, { Component, PropTypes } from 'react';
import { connect } from 'react-redux';
import request from 'superagent';
import ChatContainer from './ChatContainer';
import ChatInput from './ChatInput';
import { asyncGetList } from '../redux/actions';
import socketIntialize from '../redux/socket';
import { now } from '../util';

class App extends Component {
  componentDidMount() {
    const { dispatch } = this.props;
    socketIntialize(dispatch);
    asyncGetList(dispatch, { timestamp: now() });
  }
  getList(chat) {
    const { dispatch } = this.props;
    asyncGetList(dispatch, chat);
  }
  send(message) {
    request
        .post('/api/message/write')
        .type('application/json')
        .send({
          sender: {
            seq: 1,
          },
          timestamp: now(),
          message,
        })
        .end((err, data) => {
          console.log(data.body);
        });
  }

  render() {
    const { chats } = this.props;
    return (
      <div>
        <ChatContainer getList={this.getList} chats={chats} />
        <ChatInput send={this.send} />
      </div>
    );
  }
}

App.propTypes = {
  chats: PropTypes.arrayOf(React.PropTypes.object),
  dispatch: PropTypes.func.isRequired,
};


function mapStateToProps(state) {
  const { chats } = state;
  return {
    chats,
  };
}


export default connect(mapStateToProps)(App);
