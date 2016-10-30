var notify = require("gulp-notify");
var argv = require('yargs').argv;

module.exports = function() {

    var args = Array.prototype.slice.call(arguments);
    var notification = argv.notification === undefined ? true : argv.notification;
    if(notification) {
        notify.onError({
            title:    "STUPID!!!",
            subtitle: "Failure!",
            message:  "Error: <%= error.message %>",
            sound:    "Beep"
        }).apply(this, args);
    }
    // 스트림 중간에서도 끊기지 않도록...
    this.emit('end');
};

