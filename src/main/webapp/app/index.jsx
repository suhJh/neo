import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { PageHeader } from './static-components';
import { App } from './components';

class Contents extends Component {
  render() {
    return (
      <div>
        <PageHeader />
        <App />
      </div>
    );
  }
}


/*
import request from 'superagent';
request
  .post('/api/users')
  .type('json')
  .send({ seq: 1 })
  .end((err, data) => {
    console.log('c8c8c8c8',data.body);
  });
*/

//ReactDOM.render(<App title={'소켓테스트'} />, document.getElementById('contents'));
ReactDOM.render(<Contents />, document.getElementById('contents'));
