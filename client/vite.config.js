import { defineConfig } from 'vite';

export default defineConfig({
    server: {
        proxy: {
            '/api': {
                target: 'http://localhost:8080/app',
                changeOrigin: true,
                secure: false,
            },
        },
    },
});
