module.exports = {
  entry: {
    'simplebar-react': './main.js'
  },
  output: {
    filename: '[name].inc.js'
  },
  externals: {
    'react': 'React',
    'react-dom': 'ReactDOM'
  }
};
