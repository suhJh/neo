import React from 'react';

function PageHeader() {
  return (
    <div className="jumbotron header-gradient" >
      <div className="container">
        <h1 className="f-white">
          <span className="visible-lg-inline">
            <a href="http://www.spring.io">
              <img alt="스프링 링크" className="header-span-image" src="https://spring.io/img/mobile-leaf-watermark-3405b4ec5cee6de62d891c62d937f0fe.png" />
            </a>
          </span>
            Spring
          <small style={{ marginLeft: '15px', marginRight: '15px' }}><i className="f-white">loves</i></small>
            React
          <span className="visible-lg-inline">
            <a href="https://facebook.github.io/react/">
              <img alt="리액트 링크" className="header-span-image" src="/images/react.png" />
            </a>
          </span>
        </h1>
        <p>
          스프링과 리액트를 사용하여 만드는 웹 어플리케이션 입니다.
        </p>
      </div>
    </div>
  );
}

export default PageHeader;
