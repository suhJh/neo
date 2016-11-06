import React, { Component, PropTypes } from 'react';


class SpeechBubble extends Component{
  render() {
    return (
      <div>
        <div className="row speech-bubble">
          <div
            className="col-lg-7 col-lg-push-4 arrow_box_r col-md-8 col-lg-push-3 col-sm-8 col-sm-push-3 col-xs-8 col-xs-push-3"
          >
            <h3 className="f-white">
              말풍선 테스트입니다.말풍선 테스트입니다.말풍선 테스트입니다.말풍선 테스트입니다.말풍선 테스트입니다.말풍선 테스트입니다.
            </h3>
          </div>
        </div>
        <div className="row speech-bubble">
          <div className="col-lg-7 arrow_box_l col-md-8 col-sm-8 col-xs-8">
            <h3 className="f-white">
              말풍선 테스트 2
            </h3>
          </div>
        </div>
      </div>
    );
  }
}
