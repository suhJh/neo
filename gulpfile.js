const gulp = require('gulp');

const config = require('./gulp/gulp-config');

const babelify = require('babelify');
const browserify = require('browserify');
//  const watchify = require('watchify');

const source = require('vinyl-source-stream'); // ->얘를 써야하는 이유 http://programmingsummaries.tistory.com/382
//  const buffer = require("vinyl-buffer");
//  const merge = require('utils-merge');
//  const sourcemaps = require('gulp-sourcemaps')
//  const uglify = require("gulp-uglify");
//  const rename = require('gulp-rename')

/* 오류 잡이 */
const handleErrors = require('./gulp/handleErrors');
const notify = require('gulp-notify'); // windows alert

const browserSync = require('browser-sync');

gulp.task('default', [
  'browser-sync',
  'build',
  'watch',
]);


gulp.task('browser-sync', () => {
  browserSync.init(null, {
    proxy: 'http://localhost:8080',
    files: [`${config.src.js}/*.*`],
    port: 3000,
    open: 'external',
  });
});


gulp.task('build', () => {
  const optionalB = browserify({
    insertGlobals: true,
    extensions: ['.js', '.jsx'],
  });

  optionalB.transform(babelify, { presets: ['react', 'es2015'] });

  try { //  build에 실패하면 실패하기 전의 소스를 스트림으로 반환
    optionalB.add(`${config.src.js}/index.jsx`);
  } catch (err) {
    notify.write(err);
    console.log(err);
  }

  return optionalB.bundle()
        .on('error', handleErrors)
        .pipe(source('bundle.js'))
        //  .pipe(buffer())//->ugilfy도 vinyl스트림을 사용하므로 버퍼가 필요
        //  .pipe(uglify())
        .pipe(gulp.dest(`${config.src.bundle}/`))
        .pipe(browserSync.reload({ stream: true }));
});


gulp.task('watch', () => {
  gulp.watch(`${config.src.img}/**/*.jpg`).on('change', browserSync.reload);
  gulp.watch(`${config.src.html}/**/*.html`).on('change', browserSync.reload);
  gulp.watch(`${config.src.css}/**/*.css`).on('change', browserSync.reload);
  gulp.watch(`${config.src.js}/**/*.*`, ['build']);
});
