FROM python:3.6

WORKDIR /root

RUN apt-get update && \
  apt-get install -y vim && \
  apt-get clean && \
  rm -rf /var/lib/apt/lists/*

COPY requirements.txt .
RUN pip install -r requirements.txt

COPY test.py .
RUN mkdir -p ${HOME}/.config/matplotlib && \
    echo "backend       : Agg" >> ${HOME}/.config/matplotlib/matplotlibrc && \
    python test.py
