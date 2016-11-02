import React, { PropTypes } from 'react';
import ReactDOM from 'react-dom';
import request from 'superagent';


let value = 1;

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { users: 'loading', keyword: 1 };
    this.receiveFromServer = this.receiveFromServer.bind(this);
  }
  componentDidMount() {
    this.receiveFromServer();
  }
  receiveFromServer() {
    console.log(value, 'value');
    /* 요거가 기본 사용방법 */
    request
      .post('/api/users')
      .type('json')
      .send({ seq: 1 })
      .end((err, data) => {
        console.log('c8c8c8c8',data.body);
      });
  }
  render() {
    const { title } = this.props;
    const { users } = this.state;
    return (
      <div>
        <h1>{title}</h1>
        <input
          type="text"
          ref={(ref) => { value = ref.value; }}
          onChange={this.receiveFromServer}
        />
        <h2>{users}</h2>
      </div>
    );
  }
}

App.propTypes = {
  title: PropTypes.string.isRequired,
};


ReactDOM.render(<App title={'일단..... 큰 불만 끄자'} />, document.getElementById('contents'));
