import React, { PropTypes } from 'react';
import ReactDOM from 'react-dom';
import request from 'superagent';

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
    if (!this.state.keyword) return;
    request
      .post('/api/users')
      .send({ seq: this.state.keyword })
      .end((data) => {
        this.setState({
          users: data,
        });
        console.log(this.state.users);
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
          ref={(ref) => { this.setState({ keyword: ref }); }}
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
