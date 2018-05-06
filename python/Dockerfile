FROM python:3.6

WORKDIR /root

RUN apt-get update && \
    apt-get install -y vim && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

RUN groupadd -g 1000 pyuser && \
    useradd -u 1000 -g pyuser -m pyuser

COPY requirements.txt .
RUN pip install -r requirements.txt

USER pyuser
WORKDIR /home/pyuser

RUN mkdir -p png

COPY test.py .
RUN mkdir -p .config/matplotlib && \
    echo "backend       : Agg" >> .config/matplotlib/matplotlibrc && \
    python test.py

