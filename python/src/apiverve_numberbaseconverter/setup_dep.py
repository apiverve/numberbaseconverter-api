from setuptools import setup, find_packages

setup(
    name='apiverve_numberbaseconverter',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Number Base Converter is a tool for converting numbers between different bases (2-36). It supports binary, octal, decimal, hexadecimal, and custom bases with comprehensive conversion results.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
