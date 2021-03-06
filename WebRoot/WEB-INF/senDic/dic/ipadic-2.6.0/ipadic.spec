%define prefix /usr
%define PACKAGE ipadic
%define VERSION 2.6.0

Summary: Japanese dictionary for ChaSen
Name: %{PACKAGE}
Version: %{VERSION}
Release: 1
Copyright: read COPYRIGHT file
Group: local
URL: http://chasen.aist-nara.ac.jp/
Source: %{name}-%{version}.tar.gz
BuildArchitectures: noarch
BuildRoot: /var/tmp/%{name}
Packager: Taku Kudoh <taku-ku@is.aist-nara.ac.jp>
Requires: chasen >= 2.3.1

%description 
ChaSen のための IPA品詞体系に基づく日本語辞書

形態素解析システム茶筌は，言語処理のためのフリーソフトウェアとして奈良先
端科学技術大学院大学より公開されているシステムです．本辞書は，茶筌
(version2.3.1以降)用の日本語辞書 (ipadic2.6.0)について説明したものです．本
辞書では，情報処理振興事業協会(IPA)で設定されたIPA品詞体系(THiMCO97)に基
づいて一部修正を加えました．本説明書は新情報処理開発機構(RWCP)による「テ
キストデータベース報告書(平成８年度)」に掲載されたIPA品詞体系(THiMCO97)
の説明を許可を得て抜粋し，一部修正を施したものです．

なお，現在のIPA品詞体系日本語辞書は，1998年5月に公開したIPA品詞体系日本
語辞書(ipadic1.0b2)に対して，奈良先端科学技術大学院大学情報科学研究科鹿
野清宏教授を代表とする「日本語ディクテーション基本ソフトウェアの開発」
(IPA独創的先進的情報技術に関わる研究開発)のグループの方々に大幅な修正，
改良を行っていただき，その後，様々な修正を行ったものです．

本辞書システムの構築に携わられたすべての方々にに対して心より感謝します．

本辞書に関するお問い合わせは以下にお願いします．

〒630-0192
奈良県生駒市高山町8916-5
奈良先端科学技術大学院大学
情報科学研究科\ 自然言語処理学講座

Tel: (0743)72-5240, Fax: (0743)72-5249
E-mail: chasen@is.aist-nara.ac.jp

%prep

%setup

%build
./configure --with-dicdir=%{prefix}/share/chasen/dic --with-chasenrc-path=$RPM_BUILD_ROOT%{prefix}/etc/chasenrc
make

%install
mkdir -p $RPM_BUILD_ROOT%{prefix}/etc
make dicdir=$RPM_BUILD_ROOT%{prefix}/share/chasen/dic/%{name} install

%clean
rm -rf $RPM_BUILD_ROOT

%files
%defattr(-, root, root)
%doc *.texi *.pdf
%{prefix}/lib/chasen/dic/%{name}/*
%config %{prefix}/etc/chasenrc
