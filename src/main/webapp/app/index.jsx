import React, {Component} from 'react';
import ReactDOM from 'react-dom';



class App extends Component {
    render() {
        const { title } = this.props;
        return (
            <div>
                <h2>{title}</h2>
            </div>
        );
    }
}

ReactDOM.render(<App title={"일단..... 큰 불만 끄자"} />, document.getElementById('contents'));

