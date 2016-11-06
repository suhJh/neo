import React, { Component, PropTypes } from 'react';

export default class Picker extends Component {
  constructor(props) {
    super(props);
    this.search = this.search.bind(this);
  }

  search() {
    if (this.input.value && this.input.value !== '') {
      this.props.onChange(this.input.value);
    }
  }

  render() {
    const { value, onChange, options } = this.props;

    return (
      <span>
        <h1>{value}</h1>
        <input
          type="text"
          className="form-control"
          ref={(ref) => { this.input = ref; }}
          placeholder="search for something"
        />
        <button onClick={this.search}>search</button>
        <select
          onChange={e => onChange(e.target.value)}
          value={value}
        >
          {options.map(option =>
            <option value={option} key={option}>
              {option}
            </option>)
          }
        </select>
      </span>
    );
  }
}

Picker.propTypes = {
  options: PropTypes.arrayOf(
    PropTypes.string.isRequired
  ).isRequired,
  value: PropTypes.string.isRequired,
  onChange: PropTypes.func.isRequired,
};
