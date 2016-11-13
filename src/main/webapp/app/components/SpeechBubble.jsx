import React, { Component, PropTypes } from 'react';


export default class SpeechBubble extends Component {
  render() {
    const { message, sender, timestamp } = this.props;

    let mineOrNot = 'col-lg-7 col-lg-push-4 arrow_box_r col-md-8 col-lg-push-3 col-sm-8 col-sm-push-3 col-xs-8 col-xs-push-3';
    if (sender.seq !== 1) {
      mineOrNot = 'col-lg-7 arrow_box_l col-md-8 col-sm-8 col-xs-8';
    }
    return (
      <div>
        <div className="row speech-bubble">
          <div className={mineOrNot}>
            <h3 className="f-white">
              {message}
            </h3>
            <h5>{timestamp}</h5>
          </div>
        </div>
      </div>
    );
  }
}

SpeechBubble.propTypes = {
  message: PropTypes.string,
  sender: PropTypes.object,
  timestamp: PropTypes.number,
};
