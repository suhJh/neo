import React from 'react';
import ReactDOM from 'react-dom';
import { App } from './components';

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

ReactDOM.render(<App title={'소켓테스트'} />, document.getElementById('contents'));
