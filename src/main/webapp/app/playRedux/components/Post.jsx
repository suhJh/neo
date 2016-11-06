import React, { Component, PropTypes } from 'react';

export default class Post extends Component {
  constructor(props) {
    super(props);
    this.insert = this.insert.bind(this);
  }
  insert() {
    if (this.title.value !== '' && this.contents.value !== '') {
      const { insertFunc } = this.props;
      insertFunc({
        title: this.title.value,
        contents: this.contents.value,
      });
      this.title.value = '';
      this.contents.value = '';
    } else {
      alert('빈 값을 인저트할 수 없음.');
    }
  }
  render() {
    return (
      <div>
        <input className="form-control" type="text" ref={(ref) => { this.title = ref; }} />
        <input className="form-control" type="text" ref={(ref) => { this.contents = ref; }} />
        <button className="btn" onClick={this.insert}>ADD</button>
      </div>
    );
  }
}


Post.propTypes = {
  insertFunc: PropTypes.func.isRequired,
};
