import React, { Component, PropTypes } from 'react';

export default class ChatInput extends Component {
  constructor(props) {
    super(props);
    this.inputText = '';
    this.handleText = this.handleText.bind(this);
  }
  handleText(e) {
    if (e && e.key !== 'Enter') {
      return;
    }
    const { send } = this.props;
    const text = this.inputText.value.trim();
    send(text);
    this.inputText.value = '';
  }
  render() {
    return (
      <div className="input-group">
        <input
          type="text"
          className="form-control"
          placeholder="내용을 입력하세요."
          ref={(ref) => { this.inputText = ref; }}
          onKeyPress={this.handleText}
        />
        <span className="input-group-btn">
          <button className="btn btn-default" type="button">
            <span className="glyphicon glyphicon-plus" aria-hidden="true" />
          </button>
        </span>
      </div>
    );
  }
}

ChatInput.propTypes = {
  send: PropTypes.func.isRequired,
};
