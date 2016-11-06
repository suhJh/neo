import React, { Component } from 'react';
import TimeAgo from 'react-timeago';
import koreanStrings from 'react-timeago/lib/language-strings/ko';
import buildFormatter from 'react-timeago/lib/formatters/buildFormatter';

const formatter = buildFormatter(koreanStrings)

export default class PostList extends Component {
  render() {
    const { posts } = this.props;
    const rd = posts.map(
      it => (
        <div key={it.id}>
          <span>{it.title}</span>
          <span>{it.contents}</span>
          <TimeAgo date={it.at} formatter={formatter} />
        </div>
      )
    );
    return (
      <div>{ rd }</div>
    );
  }
}
