#!/bin/sh
# docker-entrypoint.sh

set -e
cat BANNER.txt
exec "$@"
