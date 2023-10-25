import os

from argparse import ArgumentParser


def exec_sbt(pkg: str, obj: str, module: str) -> None:
    sbt_cmd: str = f'sbt "runMain {pkg}.{obj}"'

    os.system(sbt_cmd)
    os.system(f'mv ./{module}.sv ./rtl/{pkg}/{pkg}{module[-1]}.v')

    return


def clean_verilog(path: str) -> None:
    with open(path, 'r', encoding='UTF-8') as f:
        verilog: list[str] = f.readlines()

    return


def main() -> None:
    parser: ArgumentParser = ArgumentParser()
    parser.add_argument("--pkg", type=str, help="Package of entry point object")
    parser.add_argument("--obj", type=str, help="Entry point object")
    parser.add_argument('--module', type=str, help='Module class name')
    args = parser.parse_args()

    exec_sbt(args.pkg, args.obj, args.module)

    return


if __name__ == '__main__':
    main()