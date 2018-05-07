FROM python:3.6

# タイムゾーンの設定
ENV TZ=Asia/Tokyo

# 作業ディレクトリの指定
WORKDIR /root

# 利用しそうなものをインストール
RUN apt-get update && \
    apt-get install -y vim \
                       locales && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# ロケールの設定
RUN echo "ja_JP.UTF-8 UTF-8" >> /etc/locale.gen && \
    locale-gen

ENV LANG=ja_JP.UTF-8 \
    PYTHONENCODING=utf-8

# ユーザーの追加
RUN groupadd -g 1000 pyuser && \
    useradd -u 1000 -g pyuser -m pyuser

# Pythonで利用するパケージのインストール
COPY requirements.txt .
RUN pip install -r requirements.txt

# 実行ユーザーを変更
USER pyuser
# 作業ディレクトリの指定
WORKDIR /home/pyuser

# グラフの画像ファイル保存先作成
RUN mkdir -p png

# GUIは利用しないので、エラーならないようにする
# プログラムを実行しエラーにならないことを確認
COPY --chown=pyuser:pyuser test.py .
RUN mkdir -p .config/matplotlib && \
    echo "backend       : Agg" >> .config/matplotlib/matplotlibrc && \
    python test.py
