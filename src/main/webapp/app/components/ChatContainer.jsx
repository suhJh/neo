import React, { Component, PropTypes } from 'react';

export default class ChatContainer extends Component {
  render() {
    return (
      <div className="container">
        <div className="page-header">
          <h1>웹소켓을 이용한 채팅</h1>
        </div>
        <div className="row">
          <div className="col-lg-8">
            //TODO: 말풍선들 들어갈 자리
          </div>
        </div>
        <div className="clearfix col-lg-12">
          // TODO: 참가자명단
        </div>
      </div>
    );
  }
}