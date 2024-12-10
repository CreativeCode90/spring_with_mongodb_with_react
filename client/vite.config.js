import { defineConfig } from 'vite';
// this is vite config file in this file satup my spring boot backend url proxy for interect with my spring boot
export default defineConfig({
    server: {
        proxy: {
            '/api': {
                target: 'http://localhost:8080/app', // my spring boot backend url
                changeOrigin: true,
                secure: false,
            },
        },
    },
});
