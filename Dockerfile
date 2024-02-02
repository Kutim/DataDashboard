# Stage 1: Compile and Build angular codebase
FROM node:lts as build

WORKDIR /app
COPY ./ /app/
# 设置 npm 使用的国内镜像
RUN npm config set registry https://r.cnpmjs.org/
RUN npm install
# 对于 Angular CLI，使用国内镜像
RUN npm run build

# Stage 2: Serve app with nginx
FROM nginx:alpine
COPY --from=build /app/deployment/nginx.conf /etc/nginx/nginx.conf
COPY --from=build /app/dist/edc-demo-client /usr/share/nginx/html
COPY --from=build /app/src/assets /usr/share/nginx/html/assets
EXPOSE 80

HEALTHCHECK --interval=2s --timeout=5s --retries=10 \
  CMD curl -f http://localhost/ || exit 1
