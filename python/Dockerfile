FROM python:3.6

WORKDIR /root

RUN apt-get update -y --no-install-recommends && \
  apt-get install -y --no-install-recommends vim && \
  apt-get clean -y && \
  rm -rf /var/lib/apt/lists/*

COPY requirements.txt .
RUN pip install -r requirements.txt

RUN mkdir -p ${HOME}/.config/matplotlib && \
    echo "backend       : Agg" >> ${HOME}/.config/matplotlib/matplotlibrc
