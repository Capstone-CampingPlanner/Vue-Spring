module.exports = {
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8282',
        changeOrigin:true,
        pathRewrite:{ '^/api':'' }
      }
    }
  }
}
