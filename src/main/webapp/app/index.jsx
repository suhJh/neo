import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { PageHeader } from './static-components';
import { Root } from './components';

class Contents extends Component {
  render() {
    return (
      <div>
        <PageHeader />
        <Root />
      </div>
    );
  }
}

ReactDOM.render(<Contents />, document.getElementById('contents'));
