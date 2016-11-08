import moment from 'moment';


export function now() {
  return moment().format('YYYY-MM-DD HH:mm:ss.SSS');
}

export function parseDate(timestamp) {
  return moment(timestamp).format('YYYY-MM-DD HH:mm:ss.SSS');
}
