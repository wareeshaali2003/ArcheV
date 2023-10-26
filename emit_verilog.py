import os, re

from argparse import ArgumentParser


def exec_sbt(pkg: str, obj: str, module: str, num: int, dest: str) -> None:
    sbt_cmd: str = f'sbt "runMain {pkg}.{obj}{num}"'

    os.system(sbt_cmd)
    os.system(f'mv ./{module}{num}.sv {dest}')

    return


def clean_verilog(path: str) -> None:
    with open(path, 'r', encoding='UTF-8') as f:
        lines: list[str] = f.readlines()

    clean_lines: list[str] = []
    stack: list[str] = []

    i: int = 0
    while i < len(lines):
        if '`ifndef' in lines[i] or '`ifdef' in lines[i]:
            block_start: bool = True
            while block_start:
                if '`endif' in lines[i]:
                    stack.pop()
                elif '`ifdef' in lines[i] or '`ifndef' in lines[i]:
                    stack.append(lines[i])
                i += 1
                block_start = True if stack else False
            if lines[i] != '\n':
                i -= 1
        elif '//' in lines[i]:
            comment_start: int = lines[i].find('//')
            if comment_start != 0:
                clean_lines.append(
                    lines[i][: comment_start - 1] + '\n'
                )
        elif lines[i] != '\n':
            clean_lines.append(lines[i])
        i += 1

    clean_lines[0] = re.sub('[0-9]+\(', '(', clean_lines[0])

    new_file: str = ''.join(clean_lines)
    with open(path, 'w', encoding='UTF-8') as f:
        f.write(new_file)

    return


def main() -> None:
    parser: ArgumentParser = ArgumentParser()
    parser.add_argument("--pkg", type=str, help="Package of entry point object")
    parser.add_argument("--obj", type=str, help="Entry point object")
    parser.add_argument('--module', type=str, help='Module class name')
    parser.add_argument('--num', type=int, help='Module number', default=-1)
    parser.add_argument('--range', type=str, help='Module range', default='')
    args = parser.parse_args()

    dest_path: str = f'./rtl/{args.pkg}/{args.pkg}'
    if args.num != -1 and not args.range:
        file_path: str = dest_path + f'{args.num}.v'

        exec_sbt(args.pkg, args.obj, args.module, args.num, file_path)
        clean_verilog(file_path)
    else:
        end_points: list[int] = args.range.split('-')
        for i in range(int(end_points[0]), int(end_points[1]) + 1):
            file_path: str = dest_path + f'{i}.v'

            exec_sbt(args.pkg, args.obj, args.module, i, file_path)
            clean_verilog(file_path)

    return


if __name__ == '__main__':
    main()
